package com.madrid.parking.android.services;

/**
 * Created by Marcin on 03/10/2015.
 */

public interface DataManagerEvents {

    public void DataManagerStartedRequest();

    public void DataManagerFinished(String methodName, Object Data);

    public void DataManagerFinishedWithException(Exception ex);

    public void DataManagerEndedRequest();
}
