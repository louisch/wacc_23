package wacc23;

import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class Exit100ErrorListener extends ConsoleErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg,
                            RecognitionException e) {
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine,
                          msg, e);
        System.exit(100);
    }
}
