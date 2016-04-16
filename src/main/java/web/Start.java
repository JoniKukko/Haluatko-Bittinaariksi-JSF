package web;


import com.vaadin.ui.Button;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public final class Start
{

    protected static Controller controller;


    public static Layout init(Controller controller)
    {
        Start.controller = controller;

        VerticalLayout layout = new VerticalLayout();

        final TextField nameInput = new TextField("Anna nimesi");
        layout.addComponent(nameInput);

        Button button = new Button("Do not press this button");


        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                Start.controller.NewPlayer( nameInput.getValue() );
            }
        });

        layout.addComponent(button);

        return layout;
    }


}
