package project1;

import java.util.ArrayList;

public class OnlineClass extends Course{
    //instance fields
    private final String type;
    
    //constructor
    public OnlineClass(String name, String CRN, String courseNum, String section, String hours, String teacher, String type){
        super(name, CRN, courseNum, section, hours, teacher);
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "#" + super.getCRN() + " " + super.getName() + " " + super.getCourseNum() + "-" + super.getSection() + " " + type + " " + super.getTeacher();
    }
    
    @Override
    public boolean conflictsWith(Course compCourse){
        if(super.getCRN().equals(compCourse.getCRN()))
            return true;
        else
            return false;
    }
}
