package testcases

import BaseTestClass
import org.testng.annotations.Test

class TestButtonNameChange: BaseTestClass() {

    /*
    In this Testcase I want you to go to this website (http://uitestingplayground.com/textinput) and check for the Text
    of the button. Afterwards, I want you to change the name of that button using the text field above of it. To change
    the name of the button, you have to click the button after you entered some text in the text field.
    Please think beforehand about sufficient and adequate Assertions/ validations. To see how assertions work, please
    see the other example test.

    In order to run the test, open the repo in your terminal and enter `gradle test --info`. This runs the tests.
    You can set the variable `isHeadless` to false to see an actual browser window pop up.

    Happy coding! :)
     */

    @Test
    fun checkButtonTest() {
        isHeadless = false

    }
}