package Mediator;

public class DIY {
    public static void main(String[] args) {
        var dialog = new LoginDialogBox();
        dialog.simulateUserInteraction();
    }
}


abstract class DialogBox {
    public abstract void changed(UIControl uiControl);
}

class UIControl {
    protected DialogBox owner;

    public UIControl(DialogBox owner) {
        this.owner = owner;
    }

    protected void notifyOwner() {
        owner.changed(this);
    }
}

class TextBox extends UIControl {
    private String content;

    public TextBox(DialogBox owner) {
        super(owner);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyOwner();
    }
}

class Button extends UIControl {
    private boolean isEnabled;

    public Button(DialogBox owner) {
        super(owner);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
        
    }
}

class LoginDialogBox extends DialogBox {
    private TextBox loginTextBox = new TextBox(this);
    private TextBox passwordTextBox = new TextBox(this);
    private Button loginButton = new Button(this);

    //User Interaction
    public void simulateUserInteraction() {
        
        loginTextBox.setContent("user");
        passwordTextBox.setContent("password");
        System.out.println("Login TextBox: " + loginTextBox.getContent());
        System.out.println("Password TextBox: " + passwordTextBox.getContent());
        System.out.println("Login Button: " + loginButton.isEnabled());

        loginTextBox.setContent("panther");
        passwordTextBox.setContent("password");
        System.out.println("Login TextBox: " + loginTextBox.getContent());
        System.out.println("Password TextBox: " + passwordTextBox.getContent());
        System.out.println("Login Button: " + loginButton.isEnabled());

        loginTextBox.setContent("user");
        passwordTextBox.setContent("");
        System.out.println("Login TextBox: " + loginTextBox.getContent());
        System.out.println("Password TextBox: " + passwordTextBox.getContent());
        System.out.println("Login Button: " + loginButton.isEnabled());
    }

    @Override
    public void changed(UIControl uiControl) {
        if (uiControl == loginTextBox || uiControl == passwordTextBox) {
            var loginContent = loginTextBox.getContent();
            var passwordContent = passwordTextBox.getContent();
            var isValid = "admin".equals(loginContent) && "1234".equals(passwordContent);
            loginButton.setEnabled(isValid);

        }
    }
}