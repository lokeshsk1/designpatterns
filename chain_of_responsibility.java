class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java");
        TeamLead teamLead = new TeamLead();
        Manager manager = new Manager();
        Director director = new Director();

        teamLead.setNextHandler(manager);
        manager.setNextHandler(director);

        teamLead.handleLeave(2);
        teamLead.handleLeave(6);
        teamLead.handleLeave(20);
        teamLead.handleLeave(100);
    }
}

abstract class LeaveHandler{

    protected LeaveHandler nextLeaveHandler = null;

    abstract void handleLeave(int days);

    public void setNextHandler(LeaveHandler leaveHandler){
        this.nextLeaveHandler = leaveHandler;
    }
}

class TeamLead extends LeaveHandler{

    @Override
    public void handleLeave(int days){
        if(days <= 3){
            System.out.println("TL approved leave"); 
        }else if(nextLeaveHandler != null){
            nextLeaveHandler.handleLeave(days);
        }else{
            System.out.println("Leave unhandled"); 
        }
    }    

}

class Manager extends LeaveHandler{

    @Override
    public void handleLeave(int days){
        if(days <= 10){
            System.out.println("Manager approved leave"); 
        }else if(nextLeaveHandler != null){
            nextLeaveHandler.handleLeave(days);
        }else{
            System.out.println("Leave unhandled"); 
        }
    }

}

class Director extends LeaveHandler{

    @Override
    public void handleLeave(int days){
        if(days <= 30){
            System.out.println("Director approved leave"); 
        }else if(nextLeaveHandler != null){
            nextLeaveHandler.handleLeave(days);
        }else{
            System.out.println("Leave unhandled"); 
        }
    }

}



