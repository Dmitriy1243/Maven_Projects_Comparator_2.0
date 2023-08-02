    import enums.StudyProfile;

    public class Statistics {

    private StudyProfile profile;
    private float avgExamScore;
    private int KolStudentsProf;
    private int KolUniversitiesProf;
    private String universityNames;


        public StudyProfile getProfile() {
            return profile;
        }

        public void setProfile(StudyProfile profile) {
            this.profile = profile;
        }

        public float getAvgExamScore() {
            return avgExamScore;
        }

        public void setAvgExamScore(float avgExamScore) {
            this.avgExamScore = avgExamScore;
        }

        public int getKolStudentsProf() {
            return KolStudentsProf;
        }

        public void setKolStudentsProf(int kolStudentsProf) {
            KolStudentsProf = kolStudentsProf;
        }

        public int getKolUniversitiesProf() {
            return KolUniversitiesProf;
        }

        public void setKolUniversitiesProf(int kolUniversitiesProf) {
            KolUniversitiesProf = kolUniversitiesProf;
        }

        public String getUniversityNames() {
            return universityNames;
        }

        public void setUniversityNames(String universityNames) {
            this.universityNames = universityNames;
        }
    }
