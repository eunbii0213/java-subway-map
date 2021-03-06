package subway.view;

import subway.repository.LineRepository;

public class View {
    protected static final String INFO_MESSAGE = "[INFO] ";
    protected static final String QUIT_GUIDE_MESSAGE = "Q. 종료";
    protected static final String GO_BACK_GUIDE_MESSAGE = "B. 돌아가기";
    protected static final String MAIN_MESSAGE = "## 메인 화면";
    protected static final String STATION_MANAGE_GUIDE_MESSAGE = "1. 역 관리";
    protected static final String LINE_MANAGE_GUIDE_MESSAGE = "2. 노선 관리";
    protected static final String SECTION_MANAGE_GUIDE_MESSAGE = "3. 구간 관리";
    protected static final String SHOW_LINE_GUIDE_MESSAGE = "4. 지하철 노선도 출력";
    protected static final String SELECT_GUIDE_MESSAGE = "## 원하는 기능을 선택하세요.";
    protected static final String PRINT_HYPHEN = "---";
    private static final String SHOW_ALL_LINES_AND_STATIONS_MESSAGE = "## 지하철 노선도";

    public static void showMainGuide() {
        System.out.println();
        System.out.println(MAIN_MESSAGE);
        System.out.println(STATION_MANAGE_GUIDE_MESSAGE);
        System.out.println(LINE_MANAGE_GUIDE_MESSAGE);
        System.out.println(SECTION_MANAGE_GUIDE_MESSAGE);
        System.out.println(SHOW_LINE_GUIDE_MESSAGE);
        System.out.println(QUIT_GUIDE_MESSAGE);
        System.out.println();
    }

    public static void showSelectGuideMessage() {
        System.out.println(SELECT_GUIDE_MESSAGE);
    }

    public static void printAllLineAndStationInfo() {
        System.out.println();
        System.out.println(SHOW_ALL_LINES_AND_STATIONS_MESSAGE);

        LineRepository.getLines().forEach(line -> {
            System.out.println(INFO_MESSAGE + line.getName());
            System.out.println(INFO_MESSAGE + PRINT_HYPHEN);
            line.getSubwayMap().stream().map(station -> INFO_MESSAGE + station.getName()).forEach(System.out::println);
            System.out.println();
        });
    }

    public static void showExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
