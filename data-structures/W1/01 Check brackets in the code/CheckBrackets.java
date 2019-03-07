import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
}

class CheckBrackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        String text = reader.readLine();

        Stack<Bracket> openingBracketsStack = new Stack<>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            Bracket bracket = new Bracket(next, position + 1);

            if (next == '(' || next == '[' || next == '{') {
                openingBracketsStack.push(bracket);
            }

            if (next == ')' || next == ']' || next == '}') {
                if (openingBracketsStack.empty() || !openingBracketsStack.peek().match(next)) {
                    openingBracketsStack.push(bracket);
                    break;
                }
                openingBracketsStack.pop();
            }
        }
        if (openingBracketsStack.isEmpty()) {
            System.out.println("Success");
        } else {
            Bracket bracket = openingBracketsStack.peek();
            System.out.println(bracket.position);
        }
    }
}
