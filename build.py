from parse import parse

from pyndakaas import Handler, handler, process_dir
import mistune
from pygments import highlight
from pygments.lexers.jvm import KotlinLexer
from pygments.lexers.shell import BashSessionLexer
from pygments.formatters import HtmlFormatter

import json
import base64
from pathlib import Path
from fnmatch import fnmatch


titles = {
    'hello_world': 'Hello world',
    'values': 'Values',
    'variables': 'Variables',
    'functions': 'Functions',
    'if_else': 'If/else',
    'for': 'For',
    'while': 'While',
    'when': 'When',
    'casts': 'Casts',
    # TODO: null safety
    'multiple_return_values': 'Multiple return values',
    'classes': 'Classes',
    'data_classes': 'Data classes',
    # TODO: enum classes
    # TODO: interfaces
    # TODO: inheritance
    # TODO: visibility modifiers
    'extension_methods': 'Extension methods',
    # TODO: collections, arrays, lists, sets, maps, sequences (separately or not)
    # TODO: iterators
    # TODO: functional stuff (map, filter, fold, groupBy)
    # TODO: assertions
    # TODO: try/catch and exceptions (either separately or as one article)
    # TODO: scope functions
    # TODO: operator overloading
    # TODO: generics
    # TODO: lambdas
    # TODO: annotations
    # TODO: context parameters or context receivers
    # TODO: reflection
    # TODO: labels

    # TODO: concurrency
    # (threads, coroutines, synchronization, channels & flows, mutexes, atomic)

    # 'reading_from_standard_input': 'Reading from standard input',
    # TODO: reading files
    # TODO: writing files
    # TODO: logging
    # TODO: number parsing
    # TODO: number formatting
    # TODO: environment variables
    # TODO: commandline arguments
    # TODO: running external commands
    # TODO: random numbers
    # TODO: regexes
    # TODO: measuring time
    # TODO: time
    # TODO: hashing
}

@handler()
class Example(Handler):
    template = 'example'

    @staticmethod
    def should_handle(input_path: Path) -> bool:
        matches = input_path.is_dir() and fnmatch(str(input_path), 'src/examples/*')
        return matches and input_path.with_suffix('').name in titles

    def read_source(self):
        self.source = self.read_from_file(self.rel_input_path / 'main.kt')
        self.script_source = self.read_from_file(self.rel_input_path / 'run.sh')

    def initialize_extra_parameters(self):
        self.parameters['dirname'] = self.rel_input_path.name
        self.parameters['title'] = titles[self.rel_input_path.name]

        kotlinHighlight = lambda x: highlight(x, KotlinLexer(), HtmlFormatter())
        code = parse(self.source, '//', mistune.html, kotlinHighlight)

        self.parameters['code'] = code
        self.parameters['first_code_idx'] = next((idx for idx, s in enumerate(code) if len(s[1])), None)

        bashHighlight = lambda x: highlight(x, BashSessionLexer(), HtmlFormatter())
        self.parameters['script'] = parse(self.script_source, '#', mistune.html, bashHighlight)        

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
