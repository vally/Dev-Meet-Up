//
//  NetworkManager.swift
//  SEC Challenge
//
//  Created by SEC2018 on 9/19/18.
//  Copyright © 2018 SEC2018. All rights reserved.
//

import Foundation

protocol NetworkManager {
    
    typealias FileContents = [String:[[String:Any]]]
    typealias NetworkResponse = (FileContents)->()
    
    /**
     This function makes a request to "backend"
     
     - parameter completion: Completion handler that gets array of dictionaries (JSON) with raw records as argument
     */
    func getEvents(completion: NetworkResponse)
}
