from parse import parse

from pyndakaas import Handler, handler, process_dir
import mistune

import json
import base64
from pathlib import Path
from fnmatch import fnmatch


titles = {
    'hello_world': 'Hello world',
    'values': 'Values',
    'variables': 'Variables',
    'for': 'For',
    'while': 'While',
    'if_else': 'If/else',
    'when': 'When',
    'reading_from_standard_input': 'Reading from standard input',
    'functions': 'Functions',
    'multiple_return_values': 'Multiple return values',
    'extension_methods': 'Extension methods',
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

        # for the 'copy' button in code blocks
        json_source = json.dumps(self.source)
        self.parameters['sourcecode'] = json_source

        # for the link to Kotlin playground in code blocks
        json_blob = f'{{"version":"2.2.21","platform":"java","code":{json_source}}}'
        self.parameters['base64'] = base64.b64encode(json_blob.encode()).decode('utf-8')

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
