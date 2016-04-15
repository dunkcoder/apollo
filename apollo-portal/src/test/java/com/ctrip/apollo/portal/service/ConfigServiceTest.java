package com.ctrip.apollo.portal.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.ctrip.apollo.Apollo.Env;
import com.ctrip.apollo.core.ConfigConsts;
import com.ctrip.apollo.core.dto.AppConfigVO;
import com.ctrip.apollo.core.dto.ClusterDTO;
import com.ctrip.apollo.core.dto.ItemDTO;
import com.ctrip.apollo.core.dto.ReleaseDTO;
import com.ctrip.apollo.core.dto.ServiceDTO;
import com.ctrip.apollo.core.exception.ServiceException;
import com.ctrip.apollo.portal.api.AdminServiceAPI;
import com.ctrip.apollo.portal.constants.PortalConstants;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class ConfigServiceTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private ConfigService configService;

  @Mock
  private ServiceLocator serviceLocator;
  @Spy
  private AdminServiceAPI.ClusterAPI clusterAPI;
//  @Spy
//  private AdminServiceAPI.ConfigAPI configAPI;



  @Before
  public void setUp() throws ServiceException {
//    ReflectionTestUtils.setField(clusterAPI, "restTemplate", restTemplate);
//    ReflectionTestUtils.setField(configAPI, "restTemplate", restTemplate);
//
//    ReflectionTestUtils.setField(clusterAPI, "serviceLocator", serviceLocator);
//    ReflectionTestUtils.setField(configAPI, "serviceLocator", serviceLocator);
//
//    String defaultAdminService = "http://localhost:8090";
//    ServiceDTO service = new ServiceDTO();
//    service.setHomepageUrl(defaultAdminService);
//    Mockito.doReturn(service).when(serviceLocator).getAdminService(Env.DEV);
  }

//  @Test
//  public void testLoadReleaseConfig() {
//    String appId = "6666";
//    long versionId = 100;
//    long releaseId = 11111;
//
//    VersionDTO someVersion = assembleVersion(appId, "1.0", releaseId);
//    ReleaseDTO[] someReleaseSnapShots = assembleReleaseSnapShots();
//
//    when(versionAPI.getVersionById(Env.DEV, versionId)).thenReturn(someVersion);
//    when(configAPI.getConfigByReleaseId(Env.DEV, releaseId)).thenReturn(someReleaseSnapShots);
//
//    AppConfigVO appConfigVO = configService.loadReleaseConfig(Env.DEV, appId, versionId);
//
//    assertEquals(appConfigVO.getAppId(), appId);
//    assertEquals(appConfigVO.getVersionId(), versionId);
//    assertEquals(appConfigVO.getDefaultClusterConfigs().size(), 2);
//    assertEquals(appConfigVO.getOverrideAppConfigs().size(), 2);
//    assertEquals(appConfigVO.getOverrideClusterConfigs().size(), 2);
//  }
//
//  @Test
//  public void testLoadReleaseConfigOnlyDefaultConfigs() {
//    String appId = "6666";
//    long versionId = 100;
//    long releaseId = 11111;
//
//    ReleaseDTO[] someReleaseSnapShots = new ReleaseDTO[1];
//    someReleaseSnapShots[0] = assembleReleaseSnapShot(11111, ConfigConsts.DEFAULT_CLUSTER_NAME,
//                                                  "{\"6666.foo\":\"demo1\", \"6666.bar\":\"demo2\"}");
//
//    when(versionAPI.getVersionById(Env.DEV, versionId)).thenReturn(someVersion);
//    when(configAPI.getConfigByReleaseId(Env.DEV, releaseId)).thenReturn(someReleaseSnapShots);
//
//    AppConfigVO appConfigVO = configService.loadReleaseConfig(Env.DEV, appId, versionId);
//
//    assertEquals(appConfigVO.getAppId(), appId);
//    assertEquals(appConfigVO.getVersionId(), versionId);
//    assertEquals(appConfigVO.getDefaultClusterConfigs().size(), 2);
//    assertEquals(appConfigVO.getOverrideAppConfigs().size(), 0);
//    assertEquals(appConfigVO.getOverrideClusterConfigs().size(), 0);
//  }
//
//  @Test
//  public void testLoadReleaseConfigDefaultConfigsAndOverrideApp() {
//    String appId = "6666";
//    long versionId = 100;
//    long releaseId = 11111;
//    VersionDTO someVersion = assembleVersion(appId, "1.0", releaseId);
//    ReleaseDTO[] someReleaseSnapShots = new ReleaseDTO[1];
//    someReleaseSnapShots[0] = assembleReleaseSnapShot(11111, ConfigConsts.DEFAULT_CLUSTER_NAME,
//                                                  "{\"6666.foo\":\"demo1\", \"6666.bar\":\"demo2\", \"5555.bar\":\"demo2\", \"22.bar\":\"demo2\"}");
//
//    when(versionAPI.getVersionById(Env.DEV, versionId)).thenReturn(someVersion);
//    when(configAPI.getConfigByReleaseId(Env.DEV, releaseId)).thenReturn(someReleaseSnapShots);
//
//    AppConfigVO appConfigVO = configService.loadReleaseConfig(Env.DEV, appId, versionId);
//
//    assertEquals(appConfigVO.getAppId(), appId);
//    assertEquals(appConfigVO.getVersionId(), versionId);
//    assertEquals(appConfigVO.getDefaultClusterConfigs().size(), 2);
//    assertEquals(2, appConfigVO.getOverrideAppConfigs().size());
//    assertEquals(appConfigVO.getOverrideClusterConfigs().size(), 0);
//  }
//
//  @Test
//  public void testLoadReleaseConfigDefaultConfigsAndOverrideCluster() {
//    String appId = "6666";
//    long versionId = 100;
//    long releaseId = 11111;
//    VersionDTO someVersion = assembleVersion(appId, "1.0", releaseId);
//    ReleaseDTO[] someReleaseSnapShots = new ReleaseDTO[2];
//    someReleaseSnapShots[0] = assembleReleaseSnapShot(11111, ConfigConsts.DEFAULT_CLUSTER_NAME,
//                                                  "{\"6666.foo\":\"demo1\", \"6666.bar\":\"demo2\"}");
//    someReleaseSnapShots[1] = assembleReleaseSnapShot(11112, "cluster1",
//                                                  "{\"6666.foo\":\"demo1\", \"6666.bar\":\"demo2\"}");
//
//    when(versionAPI.getVersionById(Env.DEV, versionId)).thenReturn(someVersion);
//    when(configAPI.getConfigByReleaseId(Env.DEV, releaseId)).thenReturn(someReleaseSnapShots);
//
//    AppConfigVO appConfigVO = configService.loadReleaseConfig(Env.DEV, appId, versionId);
//
//    assertEquals(appConfigVO.getAppId(), appId);
//    assertEquals(appConfigVO.getVersionId(), versionId);
//    assertEquals(appConfigVO.getDefaultClusterConfigs().size(), 2);
//    assertEquals(0, appConfigVO.getOverrideAppConfigs().size());
//    assertEquals(1, appConfigVO.getOverrideClusterConfigs().size());
//  }
//
//  @Test
//  public void testLoadLastestConfig() {
//    String appId = "6666";
//    ClusterDTO[] someClusters = assembleClusters();
//    ItemDTO[] someConfigItem = assembleConfigItems();
//
//    when(clusterAPI.getClustersByApp(Env.DEV, appId)).thenReturn(someClusters);
//    when(configAPI.getLatestConfigItemsByClusters(Env.DEV, Arrays
//        .asList(Long.valueOf(100), Long.valueOf(101)))).thenReturn(someConfigItem);
//
//    AppConfigVO appConfigVO = configService.loadLatestConfig(Env.DEV, appId);
//
//    assertEquals(appConfigVO.getAppId(), "6666");
//    assertEquals(appConfigVO.getVersionId(), PortalConstants.LASTEST_VERSION_ID);
//    assertEquals(appConfigVO.getDefaultClusterConfigs().size(), 3);
//    assertEquals(appConfigVO.getOverrideAppConfigs().size(), 1);
//    assertEquals(appConfigVO.getOverrideClusterConfigs().size(), 1);
//  }
//
//  private VersionDTO assembleVersion(String appId, String versionName, long releaseId) {
//    VersionDTO version = new VersionDTO();
//    version.setAppId(appId);
//    version.setName(versionName);
//    version.setReleaseId(releaseId);
//    return version;
//  }

  private ReleaseDTO[] assembleReleaseSnapShots() {
    ReleaseDTO[] releaseSnapShots = new ReleaseDTO[3];
    releaseSnapShots[0] = assembleReleaseSnapShot(11111, ConfigConsts.CLUSTER_NAME_DEFAULT,
                                                  "{\"6666.foo\":\"demo1\", \"6666.bar\":\"demo2\",\"3333.foo\":\"1008\",\"4444.bar\":\"99901\"}");
    releaseSnapShots[1] = assembleReleaseSnapShot(11111, "cluster1", "{\"6666.foo\":\"demo1\"}");
    releaseSnapShots[2] = assembleReleaseSnapShot(11111, "cluster2", "{\"6666.bar\":\"bar2222\"}");
    return releaseSnapShots;
  }

  private ReleaseDTO assembleReleaseSnapShot(long releaseId, String clusterName,
                                                     String configurations) {
    ReleaseDTO releaseSnapShot = new ReleaseDTO();
//    releaseSnapShot.setReleaseId(releaseId);
    releaseSnapShot.setClusterName(clusterName);
    releaseSnapShot.setConfigurations(configurations);
    return releaseSnapShot;
  }

  private ClusterDTO[] assembleClusters() {
    ClusterDTO[] clusters = new ClusterDTO[2];
    clusters[0] = assembleCluster(100, "6666", ConfigConsts.CLUSTER_NAME_DEFAULT);
    clusters[1] = assembleCluster(101, "6666", "cluster1");
    return clusters;
  }

  private ClusterDTO assembleCluster(long id, String appId, String name) {
    ClusterDTO cluster = new ClusterDTO();
    cluster.setAppId(appId);
    cluster.setId(id);
    cluster.setName(name);
    return cluster;
  }

  private ItemDTO[] assembleConfigItems() {
    ItemDTO[] configItems = new ItemDTO[5];
    configItems[0] = assembleConfigItem(100, ConfigConsts.CLUSTER_NAME_DEFAULT, "6666", "6666.k1", "6666.v1");
    configItems[1] = assembleConfigItem(100, ConfigConsts.CLUSTER_NAME_DEFAULT, "6666", "6666.k2", "6666.v2");
    configItems[2] = assembleConfigItem(100, ConfigConsts.CLUSTER_NAME_DEFAULT, "6666", "6666.k3", "6666.v3");
    configItems[3] = assembleConfigItem(100, ConfigConsts.CLUSTER_NAME_DEFAULT, "5555", "5555.k1", "5555.v1");
    configItems[4] = assembleConfigItem(101, "cluster1", "6666", "6666.k1", "6666.v1");
    return configItems;
  }

  private ItemDTO assembleConfigItem(long clusterId, String clusterName, String appId,
                                           String key, String value) {
    ItemDTO configItem = new ItemDTO();
//    configItem.setClusterName(clusterName);
//    configItem.setClusterId(clusterId);
//    configItem.setAppId(appId);
    configItem.setKey(key);
    configItem.setValue(value);
    return configItem;
  }

}