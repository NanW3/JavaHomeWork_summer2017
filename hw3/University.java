/**
* Represent a University
*
*
* @author nwang89
* @version 1.0
*/
public class University {
    private String name;
    private Student[] students;
    private Professor[] professors;
    /**
     * Creates a University
     *
     * @param name the name of University
     *
     */
    public University(String name) {
        this.name = name;
        this.students = new Student[1];
        this.professors = new Professor[1];
    }
    /**
     * Checks that the student does not already exist
     * in students before adding student to the students
     * array. If the array is full it must be re-sized
     * before adding the student.
     *
     * @param student an student
     */
    public void addStudent(Student student) {
        int numStudent = 0;
        for (Student s : students) {
            if (s != null) {
                numStudent++;
            } else {
                break;
            }
        }

        boolean exist = false;
        for (int i = 0; i < numStudent; i++) {
            if (students[i].equals(student)) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            numStudent++;
            if (numStudent > students.length) {
                Student[] temp = new Student[students.length * 2];
                System.arraycopy(students, 0, temp, 0, students.length);
                students = temp;
            }
            students[numStudent - 1] = student;
        }
    }
    /**
     * Checks that the professor does not already exist in professors
     * before adding professor to its corresponding array. If the array
     * is full it must be re-sized before adding the professor.
     *
     * @param professor a instance of Professor class
     */
    public void addProfessor(Professor professor) {

        int len = professors.length;
        if (professors[len - 1] != null) {
            Professor[] temp = new Professor[len * 2];
            for (int i = 0; i < len; i++) {
                temp[i] = professors[i];
            }
            professors = temp;
            professors[len] = professor;
        } else {
            for (int i = 0; i < len; i++) {
                if (professors[i] == null) {
                    professors[i] = professor;
                    break;
                }
            }
        }
    }
     /**
     *
     * @param student a instance of Student class
     * @return true if it successfully finds and removes the student
     * from students, otherwise returns false. This method should make
     * sure that there are no “null gaps” between the students and if
     * there is a null, it is at the end of the array.
     */
    public boolean removeStudent(Student student) {
        int numStudent = 0;
        for (Student s : students) {
            if (s != null) {
                numStudent++;
            } else {
                break;
            }
        }

        for (int i = 0; i < numStudent; i++) {
            if (students[i].equals(student)) {
                for (int j = i; j < numStudent - 1; j++) {
                    students[j] = students[j + 1];
                }
                numStudent--;
                students[numStudent] = null;
                return true;
            }
        }
        return false;
    }
    /**
    * @return a String representation of all of the professors
    * and students in the University along with its name. The
    * format of this is up to you, but make sure it’s legible.
    */
    public String toString() {
        String proString = "";
        for (int i = 0; i < professors.length; i++) {
            if (professors[i] != null) {
                proString += professors[i].toString() + "\n";
            } else {
                break;
            }
        }

        String stuString = "";
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                stuString += students[i].toString() + "\n";
            } else {
                break;
            }
        }

        return  "\n" + "University " + this.name
                + " has following professors and students: \n\n"
                + proString + "\n" + stuString;
    }
}


