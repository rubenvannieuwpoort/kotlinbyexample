from parse import parse

import fnmatch
from pyndakaas import Handler, handler, process_dir

from pathlib import Path


@handler()
class ExampleHandler(Handler):
    @staticmethod
    def should_handle(source_path: Path) -> bool:
        return fnmatch.fnmatch(str(source_path), 'examples/*')

    def pre_preprocess_hook(self) -> None:
        self.script_input_path = self.rel_input_path / 'run.sh'
        self.rel_input_path = self.rel_input_path / 'main.kt'

    def post_preprocess_hook(self) -> None:
        _, self.script = self.parse(self.input_root / self.script_input_path, None)
        pass

    def pre_handle_hook(self) -> None:
        assert self.source is not None
        self.metadata['code'] = parse(self.source, '//')
        self.metadata['script'] = parse(self.script, '#')

    def output_path(self) -> Path:
        return Path(self.file_name).with_suffix('.html')

    def template(self) -> str:
        return 'example'


process_dir(Path('src'), Path('build'))
