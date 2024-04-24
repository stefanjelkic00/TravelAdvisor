import React from 'react'

function NavBar() {
  return (
    <div>
        <nav className='navbar navbar-expand-lg navbar-dark bg-primary'>          
            <a  className='navbar-brand ms-4' href='/'>Travel advisor</a>
            <div className='collapse navbar-collapse' >
                <ul className='navbar-nav mrc-auto'>
                    <li className='nav-item active'>
                        <a className='nav-link' href='/'>Home</a>
                    </li>
                    <li className='nav-item'>
                        <a className='nav-link' href='#'>Login</a>
                    </li>
                    <li className='nav-item '>
                        <a className='nav-link' href='#'>Registration</a>
                    </li>
                </ul>
            </div>     
        </nav>
    </div>
  )
}

export default NavBar