/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author YUME
 */
public class MyFacade {
    private static MyFacade MyfacadeObj = null;
    private  MyFacade(){}
    public static MyFacade getMyFacadeObj(){
        if (MyfacadeObj == null){
            MyfacadeObj = new MyFacade();
        }
        return MyfacadeObj;
    }
    
    public void start(){
        ScheduleServer scheduleServer = new ScheduleServer();
        scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
	System.out.println("Start working......");

    }
    
    public void stop(){
        ScheduleServer scheduleServer = new ScheduleServer();
        System.out.println("After work done.........");
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
        
    }
    
}
