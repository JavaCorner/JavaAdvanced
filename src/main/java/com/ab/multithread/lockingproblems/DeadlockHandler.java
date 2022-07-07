package com.ab.multithread.lockingproblems;

import java.lang.management.ThreadInfo;

/**
 * @author Arpit Bhardwaj
 */
public interface DeadlockHandler {
    void handleDeadLock(final ThreadInfo[] deadlockThreads);
}
