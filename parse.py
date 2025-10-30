def parse(input: str, comment_marker: str, f1, f2):
    def is_empty(line):
        return len(line.lstrip()) == 0

    def is_comment(line):
        return line.lstrip().startswith(comment_marker)

    def remove_empty_lines(lines):
        while lines and is_empty(lines[0]):
            lines.pop(0)
        while lines and is_empty(lines[-1]):
            lines.pop()

    result = []
    lines = input.splitlines()
    i = 0

    # skip empty lines at start
    while i < len(lines) and is_empty(lines[i]):
        i += 1

    while i < len(lines):
        code, comments = [], []

        if not is_comment(lines[i]):
            # if starting with code we only parse code
            while i < len(lines) and not is_comment(lines[i]):
                code.append(lines[i])
                i += 1
        else:
            # first parse leading comment
            while i < len(lines) and is_comment(lines[i]):
                comments.append(lines[i].strip()[len(comment_marker):].lstrip())
                i += 1

            # parse following code (everything that's not a comment)
            while i < len(lines) and not is_comment(lines[i]):
                code.append(lines[i])
                i += 1

        remove_empty_lines(comments)
        remove_empty_lines(code)

        result.append((f1(' '.join(comments)), list(map(f2, code))))
    
    return result
