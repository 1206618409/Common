package v2;

public class CopyCommand extends Command {
    Content c;
    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msb = c.msb + c.msb;
    }

    @Override
    public void undo() {
        c.msb = c.msb.substring(0,c.msb.length()/2);
    }
}
