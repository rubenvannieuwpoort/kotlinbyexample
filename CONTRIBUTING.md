# Contributing

Thank you for your interest in contributing to Kotlin by Example!

A couple of comments about process:
- If you want to request a change, you can either open an issue, or send out a PR to implement the changes yourself.
- The HTML is generated from the code and comments from the files in `src/examples/<name>/main.kt`. These are the files that should be changed.
- There is no CI/CD to for the deployment. It needs to be done manually by the maintainer of this repository. You can use `make build` to build
  the examples locally, but the links from `index.html` will not work since they are missing the `.html` suffix.

About the philosophy:
- In general, I try to keep things as simple as possible, even if this means a tiny bit more manual work. For example, to add a new example,
  it needs to be added to `src/examples/`, and to the `titles` array in `build.py`. I have no intention to change this.
- Examples should be useful, (mostly) self-contained, reasonable in size, and only use the standard library. They should showcase language features or common and concrete tasks/patterns.

If you feel like contributing, but don't know what to contribute, consider adding syntax highlighting for Kotlin and bash code blocks (e.g. using [Pygments](https://pygments.org)).
