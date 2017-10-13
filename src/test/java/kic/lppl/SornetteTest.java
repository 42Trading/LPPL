package kic.lppl;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static kic.lppl.Sornette.*;

public class SornetteTest {
    public static double[] time = new double[]{416667, 416668, 416669, 416670, 416671, 416672, 416673, 416674, 416675, 416676, 416677, 416678, 416679, 416680, 416681, 416682, 416683, 416684, 416685, 416686, 416687, 416688, 416689, 416690, 416691, 416692, 416693, 416694, 416695, 416696, 416697, 416698, 416699, 416700, 416701, 416702, 416703, 416704, 416705, 416706, 416707, 416708, 416709, 416710, 416711, 416712, 416713, 416714, 416715, 416716, 416717, 416718, 416719, 416720, 416721, 416722, 416723, 416724, 416725, 416726, 416727, 416728, 416729, 416730, 416731, 416732, 416733, 416734, 416735, 416736, 416737, 416738, 416739, 416740, 416741, 416742, 416743, 416744, 416745, 416746, 416747, 416748, 416749, 416750, 416751, 416752, 416753, 416754, 416755, 416756, 416757, 416758, 416759, 416760, 416761, 416762, 416763, 416764, 416765, 416766, 416767, 416768, 416769, 416770, 416771, 416772, 416773, 416774, 416775, 416776, 416777, 416778, 416779, 416780, 416781, 416782, 416783, 416784, 416785, 416786, 416787, 416788, 416789, 416790, 416791, 416792, 416793, 416794, 416795, 416796, 416797, 416798, 416799, 416800, 416801, 416802, 416803, 416804, 416805, 416806, 416807, 416808, 416809, 416810, 416811, 416812, 416813, 416814, 416815, 416816, 416817, 416818, 416819, 416820, 416821, 416822, 416823, 416824, 416825, 416826, 416827, 416828, 416829, 416830, 416831, 416832, 416833, 416834, 416835, 416836, 416837, 416838, 416839, 416840, 416841, 416842, 416843, 416844, 416845, 416846, 416847, 416848, 416849, 416850, 416851, 416852, 416853, 416854, 416855, 416856, 416857, 416858, 416859, 416860, 416861, 416862, 416863, 416864, 416865, 416866};
    public static double[] price = new double[]{2034.91, 2042.03, 2044.13, 2063.15, 2060.7, 2056.29, 2057.51, 2058.18, 2047.97, 2001.26, 2008.72, 1999.9, 1981.21, 1933.88, 1923.55, 1939.44, 1929.48, 1893.06, 1910.54, 1930.46, 1940.75, 1929.77, 1914.37, 1872.92, 1831.74, 1857.52, 1832.32, 1830.06, 1785.75, 1784.81, 1796.98, 1809.07, 1791.85, 1768.04, 1754.01, 1741.92, 1765.34, 1785.87, 1807.05, 1797.9, 1813.57, 1758.5, 1775.85, 1768.07, 1725.15, 1716.43, 1731.33, 1761.02, 1760.95, 1742.41, 1734.22, 1731.33, 1711.96, 1710.56, 1663.85, 1656.57, 1616.43, 1611.78, 1669.43, 1651.7, 1662.17, 1707.62, 1698.16, 1669.59, 1623.32, 1622.89, 1648.25, 1685.88, 1670.64, 1694, 1722.13, 1706.31, 1705.01, 1735.95, 1743.88, 1775.36, 1818.09, 1812.17, 1813.04, 1775.78, 1756.78, 1756.94, 1764.34, 1812.26, 1794.48, 1802.72, 1865.28, 1863.09, 1843.68, 1893.35, 1882.88, 1915.17, 1934.48, 1912, 1907.62, 1910.38, 1881.93, 1914.18, 1933.92, 1952.46, 1974.38, 1954.74, 1958.4, 1956.65, 1993.21, 2000.73, 2019.83, 2045.57, 2047.59, 2002.27, 2030.48, 2037.54, 2043.64, 2069.43, 2043.62, 1992.19, 2011.31, 1964.96, 1992.72, 1985.37, 2038.22, 2018.29, 2041.33, 2053.25, 2086.2, 2079.23, 2061.43, 2060.43, 2047.58, 2027.91, 2004.27, 2042.32, 2022.79, 1999.28, 1995.37, 1989.62, 1945.19, 1961.19, 1968.31, 1971.8, 1968.05, 1980.25, 2009.48, 2026.87, 2022.79, 2023.39, 2041.25, 2021.78, 2022.01, 2026.15, 2030.88, 2041.01, 2141.41, 2190.04, 2248.67, 2221.63, 2270.04, 2259.56, 2249.08, 2280.56, 2284.33, 2348.77, 2364.71, 2438.89, 2436.04, 2370.25, 2411.94, 2341.18, 2330.4, 2377.23, 2400.77, 2372, 2373.93, 2324.76, 2355, 2328.78, 2369.15, 2392.48, 2376.29, 2359.96, 2340.38, 2339.7, 2304.06, 2286.95, 2258.27, 2268.42, 2266.97, 2317.76, 2295.68, 2299.64, 2323.04, 2340.8, 2332.45, 2316.51, 2351.41, 2362.82, 2378.29, 2404.29, 2410.59, 2443.15};

    @Rule
    public ContiPerfRule rule = new ContiPerfRule();

    @Test
    @PerfTest(invocations = 500, threads = 1)
    public void fit() throws Exception {
        double[] mwtc = Sornette.fit(time, price, DEFAULT_M, DEFAULT_W, time[time.length - 1] + 1d);
        System.out.println(Arrays.toString(mwtc));
    }

}