import {useEffect, useState} from "react";
import {Card} from "./card.jsx";
import empService from "../service/employee-service"

export const Home = () => {

    const [employee, setEmployee] = useState({})
    const [department, setDepartment] = useState({})
    const [organization, setOrganization] = useState({})

    useEffect(() => {
        (async () => {
            try {
                const {data} = await empService.findEmployeeDetails()
                const [epm, dep, org] = Object.values(data)
                setEmployee(epm)
                setDepartment(dep)
                setOrganization(org)
            } catch (err) {
                console.error(err.message)
            }

        })()

    }, []);

    return (
        <div className={'container'}>
            <Card title={'Employee Details'} info={employee}/>
            <Card title={'Department Details'} info={department}/>
            <Card title={'Organization Details'} info={organization}/>
        </div>
    )
}