/*
 *
 *  Copyright 2015 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.server.metrics;

import com.netflix.genie.common.exceptions.GenieException;

/**
 * Monitor thread that routinely updates the statistics object.
 *
 * @author skrishnan
 * @author tgianos
 */
public interface JobCountMonitor extends Runnable {

    /**
     * Get number of jobs running on this instance.
     *
     * @return number of running jobs
     * @throws GenieException if there is any error
     */
    int getNumInstanceJobs() throws GenieException;

    /**
     * Get number of running jobs on this instance running for &gt; 15 minutes.
     *
     * @return number of running jobs with runtime &gt; 15 minutes
     * @throws GenieException if there is any error
     */
    int getNumInstanceJobs15Mins() throws GenieException;

    /**
     * Get number of running jobs with 15m &lt; runtime &lt; 2 hours.
     *
     * @return Number of running jobs with 15m &lt; runtime &lt; 2 hours
     * @throws GenieException if there is any error
     */
    int getNumInstanceJobs2Hrs() throws GenieException;

    /**
     * Get number of running jobs with 2h &lt; runtime &lt; hours.
     *
     * @return Number of running jobs with 2h &lt; runtime &lt; hours
     * @throws GenieException if there is any error
     */
    int getNumInstanceJobs8Hrs() throws GenieException;

    /**
     * Get number of running jobs with runtime &gt; 8h.
     *
     * @return Number of running jobs with runtime &gt; 8h
     * @throws GenieException if there is any error
     */
    int getNumInstanceJobs8HrsPlus() throws GenieException;

    /**
     * Tell the monitor thread to stop running at next iteration.
     *
     * @param stop true if the thread should stop running
     */
    void setStop(final boolean stop);
}
