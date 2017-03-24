package services;

import model.Bike;
import model.Client;
import model.Order;
import model.Parcel;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Admin on 19.07.2014.
 */
public enum OrderService implements IOrderService {
    INSTANCE;

    private AtomicInteger lastId;
    private IOrderDao orderDao;

    private CurrentTaskService()
    {

        ctd = new CurrentTaskDao();
        int lId = ctd.getLastId();
        lastId = new AtomicInteger(lId);


    }

    @Override
    public CurrentTask saveCurrentTask(int taskId, int creatorId, int recipientId, String priority)
    {


        CurrentTask ct = new CurrentTask(lastId.incrementAndGet(), taskId, creatorId, recipientId, "NEW", priority, new Date());

        boolean flag = ctd.saveCurrentTask(ct);
        return ct;
    }

    @Override
    public List<CurrentTask> getAllCurrentTasks()
    {
        return ctd.getAllCurrentTasks();
    }

    @Override
    public List<CurrentTask> getAllByUserId(User user)
    {
        List<CurrentTask> ctasks = ctd.getAllByUserId(user);
        return ctasks;
    }

    @Override
    public List<CurrentTask> getAllByCreatorId(User user)
    {
        List<CurrentTask> ctasks = ctd.getAllByCreatorId(user);
        return ctasks;

    }

    @Override
    public List<CurrentTask> getAllByTaskId(Task task)
    {
        return ctd.getAllByTaskId(task);
    }

    @Override
    public Parcel<CurrentTask> getCurrentTaskPage(User user, int pageNumber)
    {
        int from = (pageNumber*5);
        int to = (pageNumber +1) * 5;
        return ctd.getCurrentTaskPage(user, from, to);
    }

    public Parcel<CurrentTask> getCurrentTaskPageAll(int pageNumber)
    {
        int from = (pageNumber*5);
        int to = (pageNumber +1) * 5;
        return  ctd.getCurrentTaskPageAll(from, to);
    }

    @Override
    public boolean setStartDate(CurrentTask ct) {
        Date cd = new Date();
        if(ctd.setStartDate(ct, cd))
        {
            ct.setStartDate(cd);
            return true;
        }

        return false;
    }

    @Override
    public boolean setEndDate(CurrentTask ct)
    {
        Date cd = new Date();
        if(ctd.setEndDate(ct, cd))
        {
            ct.setEndDate(cd);
            return true;
        }
        return false;
    }

    public boolean setPriority(CurrentTask ct, String priority)
    {
        return ctd.setPriority(ct, priority);
    }

    public boolean setStateStart(CurrentTask ct)
    {
        if (ctd.setState(ct, "STARTED"))
        {
            ct.setState("STARTED");
            return true;
        }
        return false;
    }

    public boolean setStateFinish(CurrentTask ct)
    {
        if(ctd.setState(ct,"FINISHED"))
        {
            ct.setState("FINISHED");
            return true;
        }
        return false;
    }
}
