import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

// Right side of PopupWindow
public class RightFormPanel extends JPanel {
    private static RightFormPanel instance;
    private DefaultListModel<String> stepsModel;
    private JList<String> stepsList;
    // Make singleton
    public static RightFormPanel getInstance(){
        if(instance == null){
            instance = new RightFormPanel();
        }
        return instance;
    }
    private RightFormPanel(){
        super();
        this.setPreferredSize(new Dimension(300, 500));
        this.setMaximumSize(new Dimension(300, 500));
        this.setBorder(new EmptyBorder(12, 12, 12, 12));
        this.setBackground(Color.decode("#DDE0FB"));
        // Sets a vertical layout
        BoxLayout rightFormPanelLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(rightFormPanelLayout);
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 67)));
        // Steps list label
        this.add(this.buildStepsLabel());
        // Spacer
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        // Steps list
        this.add(this.buildStepsList());
        // Panel that holds add and delete steps buttons
        this.add(this.buildStepsButtonsPanel());
    }
    // Steps list label
    private JLabel buildStepsLabel(){
        return new JLabel("Steps");
    }
    // Steps list
    private JList<String> buildStepsList(){
        this.stepsModel = new DefaultListModel<>();
        this.stepsList = new JList<>(stepsModel);
        this.stepsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.stepsList.setPreferredSize(new Dimension(300,250));
        this.stepsList.setMaximumSize(new Dimension(300,250));
        this.stepsList.setAlignmentX(0);
        return this.stepsList;
    }
    // Panel that holds add and delete steps buttons
    private JPanel buildStepsButtonsPanel(){
        JPanel stepsButtonsPanel = new JPanel();
        stepsButtonsPanel.setBorder(new EmptyBorder(12, 0, 12, 0));
        stepsButtonsPanel.setBackground(Color.decode("#DDE0FB"));
        stepsButtonsPanel.setAlignmentX(0);
        // Sets a horizontal layout
        BoxLayout stepsButtonsPanelLayout = new BoxLayout(stepsButtonsPanel, BoxLayout.X_AXIS);
        stepsButtonsPanel.setLayout(stepsButtonsPanelLayout);
        // Add new step button
        stepsButtonsPanel.add(this.buildAddNewStepButton());
        // Spacer
        stepsButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        // Delete step button
        stepsButtonsPanel.add(this.buildDeleteStepButton());
        return stepsButtonsPanel;
    }
    // Add new step button
    private JButton buildAddNewStepButton(){
        JButton addNewStepButton = new Button("Add");
        addNewStepButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        addNewStepButton.setPreferredSize(new Dimension(140, 25));
        addNewStepButton.setMaximumSize(new Dimension(140, 25));
        addNewStepButton.addActionListener(ae -> {
            String step = (String)JOptionPane.showInputDialog(addNewStepButton, "Enter a step",
                    "", JOptionPane.PLAIN_MESSAGE, null, null, "");
            if(step != null && !step.equals("")){
                this.stepsModel.addElement(step);
                this.refreshStepsListContents();
            }
        });
        return addNewStepButton;
    }
    // Delete step button
    private JButton buildDeleteStepButton(){
        JButton deleteStepButton = new Button("Delete");
        deleteStepButton.setFont(new Font("Dialog", Font.PLAIN, 14));
        deleteStepButton.setPreferredSize(new Dimension(140, 25));
        deleteStepButton.setMaximumSize(new Dimension(140, 25));
        deleteStepButton.addActionListener(ae -> {
            String step = this.stepsList.getSelectedValue();
            this.stepsModel.removeElement(step);
            this.refreshStepsListContents();
        });
        return deleteStepButton;
    }
    // Updates the contents in the steps list
    private void refreshStepsListContents(){
        this.stepsList.setModel(this.stepsModel);
    }
    // Clears all user input
    public void clearInputs(){
        this.stepsModel = new DefaultListModel<>();
        this.refreshStepsListContents();
    }
    // Returns steps arraylist
    public ArrayList<String> getSteps(){
        ArrayList<String> steps = new ArrayList<>();
        for(int i = 0; i < this.stepsModel.getSize(); i++){
            steps.add(this.stepsModel.get(i));
        }
        return steps;
    }
}
