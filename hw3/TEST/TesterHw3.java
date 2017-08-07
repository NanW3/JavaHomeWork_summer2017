class TesterHw3 {
    public static void main(String[] args) {
        University gatech = new University("Georgia Tech");

        Student studentA = new Student("A", 19, "Atlanta", 3.8, 
                                903238175, new String[]{"CS1331","CS1332","CS3510"});

        Undergrad studentB = new Undergrad("B", 20, "Washington", 3.9, 
                                903232381, new String[]{"CS1331","CS3510","CS2864"}, 8);

        Grad studentC = new Grad("C", 23, "Seattle", 4.0, 
                                903239890, new String[]{"CS6505","CS6740","CS6242"},
                                "weighted FBL ranking method for multiple nodes and edges");

        Undergrad studentD = new Undergrad("D", 22, "San Francisco", 3.7, 
                                903231677, new String[]{"CS1331","CS1332","CS2864"}, 10);

        Grad studentE = new Grad("E", 23, "Seattle", 3.9, 
                                903232136, new String[]{"CS6140","CS6740","CS6242"},
                                "Computing with biomolecules");

        gatech.addStudent(studentA);
        gatech.addStudent(studentB);
        gatech.addStudent(studentC);

        Professor professorA = new Professor("Evelyn Hart", 50, "New York", 
                                            100, new String[]{"CS1331", "CS6140"});

        Professor professorB = new Professor("Mark Michael", 40, "Los Angeles", 
                                            150, new String[]{"CS1332", "CS6740"});

        gatech.addProfessor(professorA);

        System.out.println(gatech);

        gatech.removeStudent(studentA);
        gatech.removeStudent(studentE);
        gatech.removeStudent(studentB);
        gatech.removeStudent(studentC);
        gatech.addStudent(studentD);
        gatech.addStudent(studentD);
        gatech.addStudent(studentE);

        gatech.addProfessor(professorB);

        System.out.println(gatech);



    }
}