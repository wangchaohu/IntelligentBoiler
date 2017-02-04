package com.lapsen.intelligentboiler.beans;

import java.util.List;

/**
 * Created by lapsen_wang on 2017/2/4/0004.
 */

public class JsonBean {
    /**
     * status : 200
     * result : [{"city":"石家庄","project":[{"project":"演示","MonitorBoiler":[{"boiler1":"锅炉","boiler2":"电磁炉","boiler3":"电饭煲"}]}]},{"city":"石家庄","project":[{"project":"演示","MonitorBoiler":[{"boiler1":"锅炉","boiler2":"电磁炉","boiler3":"电饭煲"}]}]}]
     */

    private String status;
    private List<ResultBean> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * city : 石家庄
         * project : [{"project":"演示","MonitorBoiler":[{"boiler1":"锅炉","boiler2":"电磁炉","boiler3":"电饭煲"}]}]
         */

        private String city;
        private List<ProjectBean> project;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ProjectBean> getProject() {
            return project;
        }

        public void setProject(List<ProjectBean> project) {
            this.project = project;
        }

        public static class ProjectBean {
            /**
             * project : 演示
             * MonitorBoiler : [{"boiler1":"锅炉","boiler2":"电磁炉","boiler3":"电饭煲"}]
             */

            private String project;
            private List<MonitorBoilerBean> MonitorBoiler;

            public String getProject() {
                return project;
            }

            public void setProject(String project) {
                this.project = project;
            }

            public List<MonitorBoilerBean> getMonitorBoiler() {
                return MonitorBoiler;
            }

            public void setMonitorBoiler(List<MonitorBoilerBean> MonitorBoiler) {
                this.MonitorBoiler = MonitorBoiler;
            }

            public static class MonitorBoilerBean {
                /**
                 * boiler1 : 锅炉
                 * boiler2 : 电磁炉
                 * boiler3 : 电饭煲
                 */

                private String boiler1;
                private String boiler2;
                private String boiler3;

                public String getBoiler1() {
                    return boiler1;
                }

                public void setBoiler1(String boiler1) {
                    this.boiler1 = boiler1;
                }

                public String getBoiler2() {
                    return boiler2;
                }

                public void setBoiler2(String boiler2) {
                    this.boiler2 = boiler2;
                }

                public String getBoiler3() {
                    return boiler3;
                }

                public void setBoiler3(String boiler3) {
                    this.boiler3 = boiler3;
                }
            }
        }
    }
}
