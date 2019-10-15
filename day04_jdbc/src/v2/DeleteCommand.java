package v2;

public class DeleteCommand extends Command{
    Content c;
    String deleted;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        deleted = c.msb.substring(0,5);
        c.msb = c.msb.substring(5,c.msb.length());
    }

    @Override
    public void undo() {
        c.msb = deleted +c.msb;
    }
}
