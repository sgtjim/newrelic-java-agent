package org.apache.log4j;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.apache.log4j.Priority;

@Weave(originalName = "org.apache.log4j.Category")
public class Category_Instrumentation {

    protected void forcedLog(String fqcn, Priority level, Object message, Throwable t) {
        NewRelic.incrementCounter("Logging/lines");
        NewRelic.incrementCounter("Logging/lines/" + level.toString());
        Weaver.callOriginal();
    }

}