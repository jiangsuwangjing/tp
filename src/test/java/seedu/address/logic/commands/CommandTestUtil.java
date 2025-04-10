package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ASSIGNMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SUBJECT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.lesson.Lesson;
import seedu.address.model.student.NameContainsKeywordsPredicate;
import seedu.address.model.student.Student;
import seedu.address.testutil.EditLessonDescriptorBuilder;
import seedu.address.testutil.EditStudentDescriptorBuilder;

/**
 * Contains helper methods for testing commands. */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_SUBJECT_HUSBAND = "husband";
    public static final String VALID_SUBJECT_FRIEND = "friend";
    public static final String VALID_SUBJECT_AMY = "CS2103T";
    public static final String VALID_SUBJECT_BOB = "CS2101";
    public static final String VALID_DATE_AMY = "28-02-2026";
    public static final String VALID_DATE_BOB = "26-09-2026";
    public static final String VALID_TIME_AMY = "12:00";
    public static final String VALID_TIME_BOB = "15:00";
    public static final String VALID_ASSIGNMENT_NAME_AMY = " Some Assignment ";
    public static final String VALID_ASSIGNMENT_NAME_BOB = " some other assignment ";
    public static final String VALID_PREAMBLE = " 1 ";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String SUBJECT_DESC_FRIEND = " " + PREFIX_SUBJECT + VALID_SUBJECT_FRIEND;
    public static final String SUBJECT_DESC_HUSBAND = " " + PREFIX_SUBJECT + VALID_SUBJECT_HUSBAND;
    public static final String SUBJECT_DESC_AMY = " " + PREFIX_SUBJECT + VALID_SUBJECT_AMY;
    public static final String SUBJECT_DESC_BOB = " " + PREFIX_SUBJECT + VALID_SUBJECT_BOB;
    public static final String DATE_DESC_AMY = " " + PREFIX_DATE + VALID_DATE_AMY;
    public static final String DATE_DESC_BOB = " " + PREFIX_DATE + VALID_DATE_BOB;
    public static final String TIME_DESC_BOB = " " + PREFIX_TIME + VALID_TIME_BOB;
    public static final String ASSIGNMENT_NAME_DESC_AMY = " " + PREFIX_ASSIGNMENT + VALID_ASSIGNMENT_NAME_AMY;
    public static final String ASSIGNMENT_NAME_DESC_BOB = " " + PREFIX_ASSIGNMENT + VALID_ASSIGNMENT_NAME_BOB;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_SUBJECT_DESC = " " + PREFIX_SUBJECT + "@@@";
    public static final String INVALID_DATE_DESC = " " + PREFIX_DATE + "17-19-2024"; // month must be within 0-12
    public static final String INVALID_TIME_DESC = " " + PREFIX_TIME + "27:00"; // time must be within 0-24
    public static final String INVALID_ASSIGNMENT_NAME_DESC = " "
            + PREFIX_ASSIGNMENT + "Math Exercise #1"; // '#' not allowed in assignment names

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditStudentCommand.EditStudentDescriptor STUDENT_DESC_AMY;
    public static final EditStudentCommand.EditStudentDescriptor STUDENT_DESC_BOB;
    public static final EditLessonCommand.EditLessonDescriptor LESSON_DESC_AMY;
    public static final EditLessonCommand.EditLessonDescriptor LESSON_DESC_BOB;

    static {
        STUDENT_DESC_AMY = new EditStudentDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withSubjects(VALID_SUBJECT_FRIEND).build();
        STUDENT_DESC_BOB = new EditStudentDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withSubjects(VALID_SUBJECT_HUSBAND, VALID_SUBJECT_FRIEND).build();

        LESSON_DESC_AMY = new EditLessonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withDate(VALID_DATE_AMY).withTime(VALID_TIME_AMY).withSubject(VALID_SUBJECT_FRIEND).build();
        LESSON_DESC_BOB = new EditLessonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withDate(VALID_DATE_BOB).withTime(VALID_TIME_BOB).withSubject(VALID_SUBJECT_FRIEND).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccessWithUpdate(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, true);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered student list and selected student in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Student> expectedFilteredList = new ArrayList<>(actualModel.getFilteredStudentList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredStudentList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the student at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showStudentAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredStudentList().size());

        Student student = model.getFilteredStudentList().get(targetIndex.getZeroBased());
        final String[] splitName = student.getName().fullName.split("\\s+");
        model.updateFilteredStudentList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredStudentList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the lesson at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showLessonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredLessonList().size());

        Lesson lesson = model.getFilteredLessonList().get(targetIndex.getZeroBased());
        model.updateFilteredLessonList(l -> l.equals(lesson));

        assertEquals(1, model.getFilteredLessonList().size());
    }
}
