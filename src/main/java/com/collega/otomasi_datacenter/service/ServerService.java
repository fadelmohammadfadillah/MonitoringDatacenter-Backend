package com.collega.otomasi_datacenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Server;
import com.collega.otomasi_datacenter.model.ServerConfig;
import com.collega.otomasi_datacenter.model.ServerPort;
import com.collega.otomasi_datacenter.model.Subproduct;
import com.collega.otomasi_datacenter.repository.ServerConfigRepository;
import com.collega.otomasi_datacenter.repository.ServerPortRepository;
import com.collega.otomasi_datacenter.repository.ServerRepository;
import com.collega.otomasi_datacenter.repository.SubproductRepository;
import com.collega.otomasi_datacenter.vo.ServerConfigRequest;

@Service
public class ServerService {
    @Autowired
    private ServerConfigRepository serverConfigRepository;

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ServerPortRepository serverPortRepository;

    @Autowired
    private SubproductRepository subproductRepository;

    public String createServerConfig(ServerConfigRequest request){
        try {
            ServerPort serverPort = serverPortRepository.findByPort(request.getPort());
            if (serverPort == null){
                serverPort = ServerPort.builder().port(request.getPort()).build();
                serverPortRepository.save(serverPort);
            }

            Server server = serverRepository.findById(request.getIdServer())
                .orElseThrow(() -> new RuntimeException("server tidak ditemukan!"));
                
            Subproduct subproduct = subproductRepository.findById(request.getIdSubproduct())
                .orElseThrow(() -> new RuntimeException("subproduct tidak ditemukan!"));
            ServerConfig serverConfig = ServerConfig.builder()
                                    .idServer(server)
                                    .idServerPort(serverPort)
                                    .idSubproduct(subproduct)
                                    .build();
            serverConfigRepository.save(serverConfig);
            return "Data konfigurasi server subproduk berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Konfigurasi Server Subproduk gagal ditambahkan!" + e.getMessage());
        }
    }

    public String createServer(ServerConfigRequest request){
        try {
            Server server = Server.builder()
                        .ipAddress(request.getIpAddress())
                        .serverType(request.getServerType())
                        .build();
            serverRepository.save(server);
            return "Data konfigurasi server berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Konfigurasi Server gagal ditambahkan!" + e.getMessage());
        }
    }

    public String updateServerConfig(Integer id, ServerConfigRequest request){
        try {
            ServerConfig serverConfig = serverConfigRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data konfigurasi server tidak ditemukan!"));

            ServerPort serverPort = serverPortRepository.findByPort(request.getPort());

            if (serverPort == null){
                serverPort = ServerPort.builder().port(request.getPort()).build();
                serverPortRepository.save(serverPort);
            }
            
            Subproduct subproduct = subproductRepository.findById(request.getIdSubproduct())
            .orElseThrow(() -> new RuntimeException("user subproduct tidak ditemukan!"));

            Server server = serverRepository.findById(request.getIdServer())
                .orElseThrow(() -> new RuntimeException("server tidak ditemukan!"));

            serverConfig.setIdServerPort(serverPort);
            serverConfig.setIdServer(server);
            serverConfig.setIdSubproduct(subproduct);
            serverConfigRepository.save(serverConfig);
            return "Data perubahan konfigurasi server berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data konfigurasi server gagal disimpan!" + e.getMessage());
        }
    }

    public String updateServer(Integer id, ServerConfigRequest request){
        try {
            Server server = serverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("server tidak ditemukan!"));
            server.setIpAddress(request.getIpAddress());
            server.setServerType(request.getServerType());
            serverRepository.save(server);
            return "Data perubahan server berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data server gagal disimpan!" + e.getMessage());
        }
    }

    public String deleteServerConfig(Integer id){
        try {
            ServerConfig serverConfig = serverConfigRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data konfigurasi server tidak ditemukan!"));
            serverConfigRepository.delete(serverConfig);
            return "Data konfigurasi server berhasil di hapus!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Data konfigurasi server  gagal dihapus!" + e.getMessage());
        }
    }

    public String deleteServer(Integer id){
        try {
            Server server = serverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data server tidak ditemukan!"));
                serverRepository.delete(server);
            return "Data server berhasil di hapus!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Data server gagal dihapus!" + e.getMessage());
        }
    }

    public List<ServerConfigRequest> getAllServerConfig(){
        List<Object[]> results = serverConfigRepository.findAllSCWithIpAndNames();
        return results.stream().map(result -> {
            ServerConfigRequest sscReq = ServerConfigRequest.builder()
                                        .idServerConfig((Integer) result[0])
                                        .idServer((Integer) result[1])
                                        .idSubproduct((Integer) result[2])
                                        .idServerPort((Integer) result[3])
                                        .ipAddress((String) result[4])
                                        .port((Integer) result[5])
                                        .subproductName((String) result[6])
                                        .serverType((String) result[7])
                                        .build();
            return sscReq;
        })
        .collect(Collectors.toList());
    }

    public List<ServerConfigRequest> getAllServer(){
        List<ServerConfigRequest> dataServer = new ArrayList<>();
        List<Server> server = serverRepository.findAll();
        dataServer.addAll(server.stream().map(svr -> {
            ServerConfigRequest serverConfig = ServerConfigRequest.builder()
                                                        .idServer(svr.getIdServer())
                                                        .ipAddress(svr.getIpAddress())
                                                        .serverType(svr.getServerType())
                                                        .build();
            return serverConfig;
        }
        ).collect(Collectors.toList()));
        return dataServer;
    }
}
