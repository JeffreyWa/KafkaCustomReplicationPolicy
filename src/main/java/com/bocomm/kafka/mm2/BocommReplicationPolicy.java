package com.bocomm.kafka.mm2;

/**
 * Customize replication policy for Bocomm
 *
 */

import java.util.Map;
import org.apache.kafka.connect.mirror.DefaultReplicationPolicy;
import org.apache.kafka.connect.mirror.MirrorConnectorConfig;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.apache.kafka.common.Configurable;



public class BocommReplicationPolicy extends DefaultReplicationPolicy {

    //private static final Logger log = LoggerFactory.getLogger(PrefixlessReplicationPolicy.class);

    private String sourceClusterAlias;

    @Override
    public void configure(Map<String, ?> props) {
        sourceClusterAlias = (String) props.get(MirrorConnectorConfig.SOURCE_CLUSTER_ALIAS);
        }


    @Override
    public String formatRemoteTopic(String sourceClusterAlias, String topic) {
        return topic;
    }

    @Override
    public String topicSource(String topic) {
        return topic == null ? null : sourceClusterAlias;
    }

    @Override
    public String upstreamTopic(String topic) {
        return null;
    }

}



