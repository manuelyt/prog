import numpy as np

# Constante gravitacional universal en UA^3 / kg * día^2
G = 0.01720209895

# Masas de los cuerpos en kg
m_sol = 1.9885e30
m_tierra = 5.9722e24
m_luna = 7.34767309e22

# Condiciones iniciales
x_sol = 1.0
y_sol = 0.0
vx_sol = 0.0
vy_sol = 0.0

x_tierra = 1.0
y_tierra = 0.0
vx_tierra = 0.0
vy_tierra = 29.783

x_luna = 0.00257
y_luna = 0.0
vx_luna = 0.0
vy_luna = 29.783

# Subintervalo de tiempo h en días
h = 1e-3

# Tiempo final t_f en días
t_f = 365

# Inicializamos la posición y la velocidad de cada cuerpo en t = 0
x_sol_arr = [x_sol]
y_sol_arr = [y_sol]
vx_sol_arr = [vx_sol]
vy_sol_arr = [vy_sol]

x_tierra_arr = [x_tierra]
y_tierra_arr = [y_tierra]
vx_tierra_arr = [vx_tierra]
vy_tierra_arr = [vy_tierra]

x_luna_arr = [x_luna]
y_luna_arr = [y_luna]
vx_luna_arr = [vx_luna]
vy_luna_arr = [vy_luna]

# Función que calcula las aceleraciones de cada cuerpo
def aceleraciones(x_sol, y_sol, x_tierra, y_tierra, x_luna, y_luna):
  r_sol_tierra = np.sqrt((x_sol - x_tierra)**2 + (y_sol - y_tierra)**2)
  r_sol_luna = np.sqrt((x_sol - x_luna)**2 + (y_sol - y_luna)**2)
  r_tierra_luna = np.sqrt((x_tierra - x_luna)**2 + (y_tierra - y_luna)**2)
  
  
  if r_sol_tierra > 0:
   ax_sol = G * (m_tierra * (x_tierra - x_sol) / r_sol_tierra**3)
   ay_sol = G * (m_tierra * (y_tierra - y_sol) / r_sol_tierra**3)
  else:
   ax_sol =0 
   ay_sol= 0

   
  if r_sol_tierra > 0 and r_tierra_luna > 0:
   ax_tierra = G * (m_sol * (x_sol - x_tierra) / r_sol_tierra**3) + G * (m_luna * (x_luna - x_tierra) / r_tierra_luna**3)
   ay_tierra = G * (m_sol * (y_sol - y_tierra) / r_sol_tierra**3) + G * (m_luna * (y_luna - y_tierra) / r_tierra_luna**3)
  else:
   ax_tierra = 0
   ay_tierra= 0

     
  ax_luna = G * (m_sol * (x_sol - x_luna) / r_sol_luna**3) + G * (m_tierra * (x_tierra - x_luna) / r_tierra_luna**3)
  ay_luna = G * (m_sol * (y_sol - y_luna) / r_sol_luna**3) + G * (m_tierra * (y_tierra - y_luna) / r_tierra_luna**3)
  
  return ax_sol, ay_sol, ax_tierra, ay_tierra, ax_luna, ay_luna

t = 0

vy_solh=0
ay_solh=0
ax_solh=0
vx_tierrah=0
vy_tierrah=0
ax_tierrah=0
ay_tierrah=0
vx_lunah=0
ax_lunah=0
vy_lunah=0
ay_lunah=0

while t < t_f:
    ax_sol, ay_sol, ax_tierra, ay_tierra, ax_luna, ay_luna = aceleraciones(
    x_sol, y_sol, x_tierra, y_tierra, x_luna, y_luna)   
    y_sol += vy_solh + 0.5*ay_solh**2
    
    vx_sol += ax_solh
    vy_sol += ay_sol*h
    
    x_tierra += vx_tierrah + 0.5*ax_tierrah**2
    y_tierra += vy_tierrah + 0.5*ay_tierrah**2
    vx_tierra += ax_tierrah
    vy_tierra += ay_tierrah
    
    x_luna += vx_lunah + 0.5*ax_lunah**2
    y_luna += vy_lunah + 0.5*ay_lunah**2
    vx_luna += ax_lunah
    vy_luna += ay_lunah

t += h

x_sol_arr.append(x_sol)
y_sol_arr.append(y_sol)
vx_sol_arr.append(vx_sol)
vy_sol_arr.append(vy_sol)

x_tierra_arr.append(x_tierra)
y_tierra_arr.append(y_tierra)
vx_tierra_arr.append(vx_tierra)
vy_tierra_arr.append(vy_tierra)

x_luna_arr.append(x_luna)
y_luna_arr.append(y_luna)
vx_luna_arr.append(vx_luna)
vy_luna_arr.append(vy_luna)

x_sol_arr = np.array(x_sol_arr)
y_sol_arr = np.array(y_sol_arr)
vx_sol_arr = np.array(vx_sol_arr)
vy_sol_arr = np.array(vy_sol_arr)

x_tierra_arr = np.array(x_tierra_arr)
y_tierra_arr = np.array(y_tierra_arr)
vx_tierra_arr = np.array(vx_tierra_arr)
vy_tierra_arr = np.array(vy_tierra_arr)

x_luna_arr = np.array(x_luna_arr)
y_luna_arr = np.array(y_luna_arr)
vx_luna_arr = np.array(vx_luna_arr)
vy_luna_arr = np.array(vy_luna_arr)


import matplotlib.pyplot as plt

plt.figure(figsize=(10,10))
plt.plot(x_sol_arr, y_sol_arr, label='Sol')
plt.plot(x_tierra_arr, y_tierra_arr, label='Tierra')
plt.plot(x_luna_arr, y_luna_arr, label='Luna')
plt.legend()
plt.xlabel('x (UA)')
plt.ylabel('y (UA)')
plt.title('Trayectoria de los cuerpos')
plt.show()


vx_sol_arr2=vy_sol_arr2=vx_tierra_arr2=vy_tierra_arr2=vx_luna_arr2=vy_luna_arr2=0
Gm_solm_tierra=Gm_solm_luna=Gm_tierram_luna=0



E_kin_sol = 0.5*m_sol(vx_sol_arr2 + vy_sol_arr2)
E_kin_tierra = 0.5*m_tierra(vx_tierra_arr2 + vy_tierra_arr2)
E_kin_luna = 0.5*m_luna(vx_luna_arr2 + vy_luna_arr2)

E_pot_sol_tierra = -Gm_solm_tierra / np.sqrt((x_sol_arr - x_tierra_arr)**2 + (y_sol_arr - y_tierra_arr)**2)
E_pot_sol_luna = -Gm_solm_luna / np.sqrt((x_sol_arr - x_luna_arr)**2 + (y_sol_arr - y_luna_arr)**2)
E_pot_tierra_luna = -Gm_tierram_luna / np.sqrt((x_tierra_arr - x_luna_arr)**2 + (y_tierra_arr - y_luna_arr)**2)

E_tot_arr = E_kin_sol + E_kin_tierra + E_kin_luna + E_pot_sol_tierra + E_pot_sol_luna + E_pot_tierra_luna

plt.figure(figsize=(10,10))
plt.plot(E_tot_arr)
plt.xlabel('Iteración')
plt.ylabel('Energía total (kg m^2 / s^2)')
plt.title('Energía total del sistema en cada iteración')
plt.show()


x_sol_arrvy_sol_arr=y_sol_arrvx_sol_arr=x_luna_arrvy_luna_arr=y_luna_arrvx_luna_arr=x_tierra_arrvy_tierra_arr=y_tierra_arrvx_tierra_arr=0

E_tot_final = E_tot_arr[-1]

L_sol = m_sol*(x_sol_arrvy_sol_arr - y_sol_arrvx_sol_arr)
L_tierra = m_tierra*(x_tierra_arrvy_tierra_arr - y_tierra_arrvx_tierra_arr)
L_luna = m_luna*(x_luna_arrvy_luna_arr - y_luna_arrvx_luna_arr)
L_tot_final = L_sol[-1] + L_tierra[-1] + L_luna[-1]

print(f'Energía total final: {E_tot_final:.3e} kg m^2/s^2')
print(f'Momento angular total final: {L_tot_final:.3e} kg m^2/s')

plt.figure(figsize=(10,10))
plt.plot(x_sol_arr, y_sol_arr, label='Sol')
plt.plot(x_tierra_arr, y_tierra_arr, label='Tierra')
plt.plot(x_luna_arr, y_luna_arr, label='Luna')
plt.legend()
plt.xlabel('x (UA)')
plt.ylabel('y (UA)')
plt.title('Trayectoria de los cuerpos')

plt.grid()
plt.axis('equal')
plt.show()

plt.figure(figsize=(10,10))
plt.plot(E_tot_arr)
plt.xlabel('Iteración')
plt.ylabel('Energía total (kg m^2 / s^2)')
plt.title('Energía total del sistema en cada iteración')
plt.show()
"""
"""
