/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeviceBasics;

/**
 *
 * @author Shane
 */
public interface ServerBasic {
    public abstract void services(String servNames[]);
    
     public enum Server_OS {
        WIN_16,
        WIN_19,
        UBUNTU_S,
        FEDORA_S,
    }
     
     
}
