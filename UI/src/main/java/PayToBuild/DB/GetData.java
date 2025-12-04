package PayToBuild.DB;

import PayToBuild.Data.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class GetData {

    private static final Map<String, List<String>> socketToMicroarch = Map.of(
            "AM4", List.of("Zen","Zen+","Zen 2","Zen 3","Zen 3D"),
            "AM5", List.of("Zen 4","Zen 4c","Zen 4 (3D V-Cache)","Zen 5","Zen 5c"),
            "LGA1151", List.of("Skylake","Kaby Lake","Coffee Lake"),
            "LGA1200", List.of("Comet Lake","Rocket Lake"),
            "LGA1700", List.of("Alder Lake","Raptor Lake","Raptor Lake Refresh"),
            "LGA1851", List.of("Arrow Lake","Panther Lake"),
            "sTRX4", List.of("Zen 2 Threadripper","Zen 3 Threadripper"),
            "LGA1150", List.of("Haswell","Broadwell"),
            "LGA775", List.of("NetBurst","Core 2")
    );

    public static List<String> getMicroarchitectures(String socket) {
        return socketToMicroarch.getOrDefault(socket.trim().toUpperCase(), List.of());
    }




    public static List<CPU> Get_Processor_Data(ResultSet resultSet) throws SQLException {
        List<CPU> cpuList = new ArrayList<>();

        while (resultSet.next()) {

            CPU cpu = new CPU(
                    resultSet.getString("name"),
                    resultSet.getFloat("price"),
                    null, // no URL for now
                    resultSet.getInt("core_count"),
                    resultSet.getFloat("core_clock"),
                    resultSet.getFloat("boost_clock"),
                    resultSet.getString("microarchitecture"),
                    resultSet.getInt("tdp"),
                    resultSet.getString("graphics")
            );

            cpuList.add(cpu);
        }

        return cpuList;
    }
}

