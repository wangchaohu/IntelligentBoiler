package com.android.intelligent.beans;

import java.util.List;

/**
 * Created by lapsen_wang on 2017/2/4/0004.
 */

public class JsonBean {
    /**
     * status : 200
     * result : [{"city":"石家庄","project":[{"project":"演示","MonitorBoiler":[{"boiler":"场景"},{"boiler":"场景2"},{"boiler":"场景3"}]}]},{"city":"石家庄","project":[{"project":"演示","MonitorBoiler":[{"boiler":"场景"},{"boiler":"场景2"},{"boiler":"场景3"}]}]}]
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
         * project : [{"project":"演示","MonitorBoiler":[{"boiler":"场景"},{"boiler":"场景2"},{"boiler":"场景3"}]}]
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
             * MonitorBoiler : [{"boiler":"场景"},{"boiler":"场景2"},{"boiler":"场景3"}]
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
                 * boiler : 场景
                 */

                private String boiler;

                public String getBoiler() {
                    return boiler;
                }

                public void setBoiler(String boiler) {
                    this.boiler = boiler;
                }
            }
        }
    }
}
