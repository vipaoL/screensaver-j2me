/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensaver;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author vipaol
 */
public class Main extends MIDlet implements CommandListener, Runnable {
    
    private boolean midletPaused = false;

    private Command exitCommand;
    private Form form;
    private StringItem stringItem;

    /**
     * The HelloMIDlet constructor.
     */
    public Main() {
    }

    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
        // write pre-initialize user code here
        // write post-initialize user code here
    }
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
        // write pre-action user code here
        switchDisplayable(null, (new BlinkingCircles().start()));
        // write post-action user code here
    }
	/**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
        // write pre-action user code here
        // write post-action user code here
    }

    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
        // write pre-switch user code here
        Display display = getDisplay();
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }
        // write post-switch user code here
    }
    
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
        // write pre-action user code here
        if (displayable == form) {
            if (command == exitCommand) {
                // write pre-action user code here
                exitMIDlet();
                // write post-action user code here
            }
        }
        // write post-action user code here
    }
	/**
     * Returns an initialized instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);
            // write post-init user code here
        }
        return exitCommand;
    }

    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
            // write pre-init user code here
            form = new Form("Welcome", new Item[] { getStringItem() });
            form.addCommand(getExitCommand());
            form.setCommandListener(this);
            // write post-init user code here
        }
        return form;
    }

    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
            // write pre-init user code here
            stringItem = new StringItem("Hello", "Hello, World!");
            // write post-init user code here
        }
        return stringItem;
    }

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void run() {
        
    }
    
}
