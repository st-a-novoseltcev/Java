package controller;

import model.AutoTest;
import utils.Command;
import view.AutoTestMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class AutoTestCtrl extends BaseCtrl{

    public AutoTestCtrl(AutoTestMenu menu) {
        super(menu);
    }


    public void loop() {  // TODO
        boolean isRunning = true;
        boolean isError   = false;
        Command command = new Command(scanner);

        while (isRunning) {
            if (!isError) {
                ((AutoTestMenu)menu).Wait();
                List<AutoTest> arrayListTests = generateTests(ArrayList.class.arrayType());
                List<AutoTest> linkedListTests = generateTests(LinkedList.class.arrayType());
                ((AutoTestMenu)menu).showData(arrayListTests);
                ((AutoTestMenu)menu).showData(linkedListTests);
                menu.show();
            }

            isError = false;
            try {
                command.getInt();
                call(command);
            } catch (InputMismatchException e) {
                isError = true;
                menu.invalidInt(command.getValue());
            } catch (NumberFormatException e) {
                isError = true;
                menu.errorCommand(String.valueOf(command.getValue()));
            } catch (InterruptedException e) {
                isRunning = false;
            }
        }
    }

    @Override
    protected void call(Command command) throws InputMismatchException, InterruptedException {
        call(command, 1);
    }


    @Deprecated
    private List<AutoTest> generateTests(Class<?> listClass) {
        List<AutoTest> result = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            result.add(new AutoTest(listClass, (int) Math.pow(10, i)));
        }
        return result;
    }

}
