from parse import parse

from pyndakaas import Handler, handler, process_dir
import mistune

from pathlib import Path
from fnmatch import fnmatch


titles = {
    'hello_world': 'Hello World',
    'values': 'Values',
    'variables': "Variables",
}

@handler()
class Example(Handler):
    template = 'example'

    @staticmethod
    def should_handle(input_path: Path) -> bool:
        result = input_path.is_dir() and fnmatch(str(input_path), 'src/examples/*')
        return result

    def read_source(self):
        self.source = self.read_from_file(self.rel_input_path / 'main.kt')
        self.script_source = self.read_from_file(self.rel_input_path / 'run.sh')

    def initialize_extra_parameters(self):
        self.parameters['dirname'] = self.rel_input_path.name
        self.parameters['title'] = titles[self.rel_input_path.name]
        self.parameters['code'] = list(map(lambda x: (mistune.html(x[0]), x[1]), parse(self.source, '//')))
        self.parameters['script'] = list(map(lambda x: (mistune.html(x[0]), x[1]), parse(self.script_source, '#')))

    def get_rel_output_path(self):
        return self.rel_input_path.parent.parent / self.rel_input_path.with_suffix('.html').name

@handler()
class Index(Handler):
    template = 'index'

    @staticmethod
    def should_handle(input_path: Path) -> bool:
        result = input_path.is_file() and fnmatch(str(input_path), 'src/index.md')
        return result

    def initialize_extra_parameters(self) -> None:
        self.parameters['links'] = titles.items()

    def transform(self) -> None:
        body = mistune.html(self.source)
        assert isinstance(body, str)
        self.body = body



process_dir(Path('src'), Path('build'))
