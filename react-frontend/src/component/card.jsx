export const Card = (props) => {
    const {title, info} = props

    return (
        <div>
            <h3>{title}</h3>
            <ul>
                {Object.entries(info).map(([k,v], index) => <li key={index}>{k}:  {v}</li>)}
            </ul>
        </div>
    )
}