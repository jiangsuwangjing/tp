package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.lesson.Lesson;
import seedu.address.model.student.Student;
import seedu.address.model.subject.Subject;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Student> PREDICATE_SHOW_ALL_STUDENTS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Lesson> PREDICATE_SHOW_ALL_LESSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a student with the same identity as {@code student} exists in the address book.
     */
    boolean hasStudent(Student student);

    /**
     * Returns true if a student has a subject.
     */
    boolean hasStudentSubject(Student student, Subject subject);

    /**
     * Deletes the given student.
     * The student must exist in the address book.
     */
    void deleteStudent(Student target);

    /**
     * Adds the given student.
     * {@code student} must not already exist in the address book.
     */
    void addStudent(Student student);

    /**
     * Replaces the given student {@code target} with {@code editedStudent}.
     * {@code target} must exist in the address book.
     * The student identity of {@code editedStudent} must not be the same
     * as another existing student in the address book.
     */
    void setStudent(Student target, Student editedStudent);

    /**
     * Deletes the given assignment to the student
     * {@code assignment} must not already exist in the student
     */
    void deleteAssignment(Student student, String assignmentName);

    /**
     * Adds the given lesson
     * {@code lesson} must not already exist in the address book
     */
    void addLesson(Lesson lesson);

    /**
     * Deletes the given lesson.
     * The lesson must exist in the address book.
     */
    void deleteLesson(Lesson lesson);

    /**
     * Returns true if a lesson with the same identity as {@code lesson} exists in the address book
     */
    boolean hasLesson(Lesson lesson);

    /**
     * Returns true if a lesson with the same date and time as {@code lesson} exists in the address book
     */
    boolean hasLessonConflict(Lesson lesson);

    /**
     * Replaces the given lesson {@code target} with {@code editedLesson}.
     * {@code target} must exist in the address book.
     * The lesson identity of {@code editedStudent} must not be the same
     * as another existing lesson in the address book.
     */
    void setLesson(Lesson target, Lesson editedLesson);

    /** Returns an unmodifiable view of the filtered student list */
    ObservableList<Student> getFilteredStudentList();

    /**
     * Updates the filter of the filtered student list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudentList(Predicate<Student> predicate);

    /** Returns an unmodifiable view of the filtered lesson list */
    ObservableList<Lesson> getFilteredLessonList();

    /**
     * Returns the current predicate of the filtered lesson list
     */
    boolean isStudentView();

    /**
     * Updates the filter of the filtered lesson list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredLessonList(Predicate<Lesson> predicate);

    /**
     * Returns the current list on display
     */
    ObservableList<?> getFilteredCurrList();
}
