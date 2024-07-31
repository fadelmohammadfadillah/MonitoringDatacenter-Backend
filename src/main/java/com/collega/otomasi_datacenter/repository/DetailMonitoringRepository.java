package com.collega.otomasi_datacenter.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.collega.otomasi_datacenter.model.DetailMonitoring;

@Repository("DetailMonitoringRepository")
public interface DetailMonitoringRepository extends JpaRepository<DetailMonitoring, Integer> {

    @Query("SELECT DISTINCT em.idMonitoring, b.bankName,  em.dateMon, em.timeMon, op.name, em.approvalStatus FROM DetailMonitoring dm JOIN dm.idBank b JOIN dm.idMonitoring em JOIN em.idOperator op")
    List<Object[]> findAllDtlMon();

    @Query(value = "select mm.id_module_mon, m.module_name , mm.status, mm.performa, mm.log, mm.operator_notes from detail_monitoring dm" +
    " join event_monitoring em ON dm.id_monitoring = em.id_monitoring " +
    " join module_monitoring mm on dm.id_dtl_mon = mm.id_dtl_mon " +
    " join module m on mm.id_module = m.id_module " +
   " where em.id_monitoring = :idMonitoring", nativeQuery = true)
    List<Object[]> findAllModuleMonByIdMon(@Param("idMonitoring") Integer idMonitoring);

    @Query(value = "select paum.id_path_app_use_mon, sp.subproduct_name, sa.ip_address, sap.path, paum.usage, paum.operator_notes, paum.status " + 
                "from server_app_path sap " + 
                "join path_app_use_monitoring paum ON sap.id_server_app_path = paum.id_server_app_path " + 
                "join detail_monitoring dm ON paum.id_dtl_mon = dm.id_dtl_mon " + 
                "join subproduct sp on dm.id_subproduct = sp.id_subproduct " + 
                "join event_monitoring em on dm.id_monitoring = em.id_monitoring " + 
                "join server_app sa on sap.id_server_app = sa.id_server_app " + 
                "where em.id_monitoring = :idMonitoring", nativeQuery = true)
    List<Object[]> findAllPathAppUseMonByIdMon(@Param("idMonitoring") Integer idMonitoring);

    @Query(value= "select pdum.id_path_db_use_mon , sp.subproduct_name, sd.ip_address, sdp.path, pdum.usage, pdum.operator_notes, pdum.status " +
                "from server_db_path sdp " +
                "join path_db_use_monitoring pdum ON sdp.id_server_db_path = pdum.id_server_db_path " + 
                "join detail_monitoring dm ON pdum.id_dtl_mon = dm.id_dtl_mon " + 
                "join subproduct sp on dm.id_subproduct = sp.id_subproduct " + 
                "join event_monitoring em on dm.id_monitoring = em.id_monitoring " + 
                "join server_db sd on sdp.id_server_db = sd.id_server_db " + 
                "where em.id_monitoring = :idMonitoring", nativeQuery = true)
    List<Object[]> findAllPathDbUseMonByIdMon(@Param("idMonitoring") Integer idMonitoring);

    @Query(value = "select bam.id_backup_app_mon, sa.ip_address, ba.directory, bam.start_backup, bam.finish_backup, bam.operator_notes, bam.status " + 
                "from backup_app ba " + 
                "join server_app sa on ba.id_server_app = sa.id_server_app " + 
                "join backup_app_monitoring bam on ba.id_backup_app = bam.id_backup_app " + 
                "join detail_monitoring dm on bam.id_dtl_mon = dm.id_dtl_mon " + 
                "join event_monitoring em on em.id_monitoring = dm.id_monitoring " + 
                "where em.id_monitoring = :idMonitoring", nativeQuery = true)
    List<Object[]> findAllBackupAppMonByIdMon(@Param("idMonitoring") Integer idMonitoring);

    @Query(value = "select bdm.id_backup_db_mon d ,sd.ip_address, bd.directory as directory_backup, bdm.start_backup, bdm.finish_backup, bdm.operator_notes, bdm.status " + //
                "from backup_db bd " + //
                "join server_db sd on bd.id_server_db = sd.id_server_db " + //
                "join backup_db_monitoring bdm on bd.id_backup_db = bdm.id_backup_db " + //
                "join detail_monitoring dm on bdm.id_dtl_mon = dm.id_dtl_mon " + //
                "join event_monitoring em on dm.id_monitoring = em.id_monitoring " + //
                "where em.id_monitoring = :idMonitoring", nativeQuery = true)
    List<Object[]> findAllBackupDbMonByIdMon(@Param("idMonitoring") Integer idMonitoring);    

    @Query(value = "select sam.id_server_app_mon, sa.ip_address, sam.cpu_usage, sam.ram_usage, sam.disk_usage, sam.log, sam.operator_notes " + //
                "from server_app_monitoring sam " + //
                "join server_app sa on sam.id_server_app = sa.id_server_app " + //
                "join detail_monitoring dm on sam.id_dtl_mon = dm.id_dtl_mon " + //
                "join event_monitoring em on dm.id_monitoring = em.id_monitoring " + //
                "where em.id_monitoring = :idMonitoring", nativeQuery = true)
    List<Object[]> findAllServerAppMonByIdMon(@Param("idMonitoring") Integer idMonitoring);

    @Query(value = "select sdm.id_server_db_mon, sd.ip_address, sdm.cpu_usage, sdm.ram_usage, sdm.disk_usage, sdm.log, sdm.operator_notes " + //
                "from server_db_monitoring sdm " + //
                "join server_db sd on sdm.id_server_db = sd.id_server_db " + //
                "join detail_monitoring dm on sdm.id_dtl_mon = dm.id_dtl_mon " + //
                "join event_monitoring em on dm.id_monitoring = em.id_monitoring " + //
                "where em.id_monitoring = :idMonitoring", nativeQuery = true)
    List<Object[]> findAllServerDbMonByIdMon(@Param("idMonitoring") Integer idMonitoring);
}