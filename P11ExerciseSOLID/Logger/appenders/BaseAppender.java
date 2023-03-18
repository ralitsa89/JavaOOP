package P11ExerciseSOLID.Logger.appenders;

import P11ExerciseSOLID.Logger.layouts.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    protected int counter;

    protected BaseAppender(Layout layout){
        this.layout = layout;

    }

    @Override
    public Layout getLayout() {
        return layout;
    }
    @Override
    public int getMessagesCount(){
        return counter;
    }
}
