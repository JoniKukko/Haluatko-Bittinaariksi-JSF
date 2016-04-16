package web;


import com.vaadin.ui.*;


public class End
{
    public static Layout init(Controller controller)
    {
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(new Label("Tämä on ENd"));

        Button button = new Button("Do not press this button");

        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                Notification.show("Do not press this button again");
            }
        });

        layout.addComponent(button);
        return layout;
    }

}
