import axios from 'axios'

const EMP_BASE_URL = 'http://localhost:9191/'

class EmployeeService {
    relativeUrl = 'api/employees/5'

    findEmployeeDetails = async () => {
        return axios.get(this.relativeUrl, {baseURL: EMP_BASE_URL});
    }
}

export default new EmployeeService()