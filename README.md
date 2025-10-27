# Kotlin by Example

Content and build toolchain for Kotlin by Example, a site that teaches Kotlin via annotated example programs.

Based on [Go by Example](https://gobyexample.com).


### Overview

Kotlin by Example is built by extracting code and comments from source files in `src/examples` and rendering them using `templates` into a static `build` directory. The build script is implemented in Python in `build.py`. Dependencies are specified in `requirements.txt`.

The built `build` directory can be served by any static content system.


### Building

To build the site you'll need Python installed with the required dependencies. First, install dependencies:

```console
$ pip install -r requirements.txt
```

Then build the site:
```console
$ make build
```

Or run the build script directly:
```console
$ python build.py
```

The `Makefile` contains a `deploy` target. Since this deploys to my homeserver, this will only work if you have SSH access to it. Which you won't, unless you're me, or you've hacked my homeserver.


### License

This work is licensed under a [Creative Commons Attribution 3.0 Unported License](http://creativecommons.org/licenses/by/3.0/).
