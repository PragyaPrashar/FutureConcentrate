package com.example.pragya.future_concentrate;

import java.util.jar.Attributes;

/**
 * Created by Pragya on 07-06-2016.
 */
public class PostModel {
    private String Name;
    private String MobileNumber;
    private String Status;
    private String HelpType;
    public void setName(String Name)
    {
        this.Name= Name;
    }
    public String getName()
    {
        return (Name);
    }
    public void setMobileNumber(String MobileNumber)
    {
     this.MobileNumber=MobileNumber;
    }
    public String getMobileNumber()
    {
        return (MobileNumber);
    }
    public void  setStatus(String Status )
    {
this.Status=Status;
    }
    public String getStatus()
    {
    return(Status);
    }
    public void setHelpType(String HelpType)
    {
    this.HelpType=HelpType;
    }
    public String getHelpType()
    {
        return(HelpType);
    }
}
