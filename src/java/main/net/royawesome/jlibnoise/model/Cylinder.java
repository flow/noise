/* Copyright (C) 2011 Garrett Fleenor

 This library is free software; you can redistribute it and/or modify it
 under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation; either version 3.0 of the License, or (at
 your option) any later version.

 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 License (COPYING.txt) for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation,
 Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 This is a port of libnoise ( http://libnoise.sourceforge.net/index.html ).  Original implementation by Jason Bevins

*/

package net.royawesome.jlibnoise.model;

import net.royawesome.jlibnoise.Utils;
import net.royawesome.jlibnoise.exception.NoModuleException;
import net.royawesome.jlibnoise.module.Module;

public class Cylinder {
	Module module;

	public Cylinder(Module mod){
		this.module = mod;
	}

	public Module getModule(){
		return this.module;
	}

	public void setModule(Module mod){
		if(mod == null) throw new IllegalArgumentException("Mod cannot be null");
		this.module = mod;
	}

	double getValue(double angle, double height){
		if(module == null) throw new NoModuleException();
		
		double x, y, z;
		x = Math.cos(angle * Utils.DEG_TO_RAD);
		y = height;
		z = Math.sin(angle * Utils.DEG_TO_RAD);
		return module.GetValue (x, y, z);

	}
}
