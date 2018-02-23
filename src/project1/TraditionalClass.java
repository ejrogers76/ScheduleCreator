package project1;

import java.time.LocalTime;

public class TraditionalClass extends Course {
    //instance fields
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String days;
    private final String location;
    private final String type;
    
    //constructor
    public TraditionalClass(String name, String CRN, String courseNum, String section, String hours, String startTime, String endTime, String days, String location, String type, String teacherName){
        super(name, CRN, courseNum, section, hours, teacherName);
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.days = days;
        this.location = location;
        this.type = type;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getDays() {
        return days;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "#" + super.getCRN() + " " + super.getName() + " " + super.getCourseNum() + "-" + super.getSection() + " [" + startTime + " " + endTime + "] " + days + " " + location + " " + type + " " + super.getTeacher();
    }
    
    @Override
    public boolean conflictsWith(Course compCourse) {
        //Initialize the condition of conflict
        boolean condition = false;
        
        //if the CRNs are the same, give true
        if(compCourse.getCRN().equals(super.getCRN()))
            condition = true;
        
        //If the CRNs are different, check further
        else{
            
            //If the course is a traditional class, check further
            if(compCourse instanceof TraditionalClass){
                TraditionalClass c = (TraditionalClass) compCourse;

                //if the days are the same, check the times
                if(c.getDays().equals(days)){

                    //If the start time and end time surround the start time, it conflicts
                    if(c.getStartTime().isBefore(startTime) && c.getEndTime().isAfter(startTime))

                        condition = true;

                    //If the start time and end time surround the end time, it conflicts
                    else if(c.getStartTime().isBefore(endTime) && c.getEndTime().isAfter(endTime))

                        condition = true;

                    //If the classes begin at the same time, they conflict
                    else if(c.getStartTime().equals(startTime))

                        condition = true;

                    //if the classes end at the same time, they conflict
                    else if(c.getEndTime().equals(endTime))

                        condition = true;

                    //otherwise they do not conflict
                    else
                        condition = false;
                }
                
                //if the days are not the same, there is no conflict
                else
                    condition = false;
            }
            
            //If the class is an online class, it can't conflict
            else{
                condition = false;
            }
        }
        
        return condition;
    }
}
