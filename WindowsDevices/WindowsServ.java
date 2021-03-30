/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WindowsDevices;
import DeviceBasics.ServerBasic;

/**
 *
 * @author Shane
 */
public class WindowsServ implements ServerBasic {
    
    private boolean domainServices = false;
    private boolean canRegisterChildren = false;
    private boolean canRegisterParent = true;
    private boolean reqEnhancedReq = false;
    
    private String ADparent;
    private String children[];
    private String accounts[];
    
    public WindowsServ(){
        accounts[0] = "Administrator";
    }
    
    
    public void services(String serviceName[]){
        for(int i = 0; i < serviceName.length; i++){
            switch(serviceName[i]){
                case "Active Directory":
                    domainServices = true;
                    canRegisterChildren = true;
                    break;
                
                case "IIS":
                    break;
            }
            
        }
    }
    
    public void RegisterADChildren (String child){
        children[-1] = child;
    }
    
    public void RegisterADParent (String parent){
        ADparent = parent;
    }
    
    public void RegisterAccounts (String acc){
        accounts[-1] = acc;
    }
}
