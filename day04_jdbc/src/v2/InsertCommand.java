package v2;

public class InsertCommand extends Command {
    Content c;
    String strToInsert = " http://www.mashibing.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msb = c.msb+strToInsert;

    }

    @Override
    public void undo() {
        c.msb = c.msb.substring(0,c.msb.length() - strToInsert.length());
    }
}
