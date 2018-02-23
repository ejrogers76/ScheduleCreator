//This is the Super class handling the basic information for the TraditionalClass and OnlineClass objects


package project1;

import java.util.ArrayList;

public abstract class Course {
    private final String name;
    private final String CRN;
    private final String courseNum;
    private final String section;
    private final String hours;
    private final String teacher;
    
    public Course(String name, String CRN, String courseNum, String section, String hours, String teacher){
        this.name = name;
        this.CRN = CRN;
        this.courseNum = courseNum;
        this.section = section;
        this.hours = hours;
        this.teacher = teacher;
    }
    public String getName() {
        return name;
    }

    public String getCRN() {
        return CRN;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public String getSection() {
        return section;
    }

    public String getHours() {
        return hours;
    }

    public String getTeacher() {
        return teacher;
    }
    
    public abstract String toString();
    
    public abstract boolean conflictsWith(Course compCourse);
    
}
