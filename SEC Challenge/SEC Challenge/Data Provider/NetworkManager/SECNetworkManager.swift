//
//  SECNetworkManager.swift
//  SEC Challenge
//
//  Created by SEC2018 on 9/19/18.
//  Copyright © 2018 SEC2018. All rights reserved.
//

import Foundation

class SECNetworkManager: NetworkManager {
    
    func getEvents(completion: (FileContents) -> ()) {
        completion(readFile(named: SECConstants.jsonFileName.rawValue))
    }
}

extension SECNetworkManager {
    
    private func readFile(named fileName: String) -> FileContents {
        
        guard let path = Bundle.main.path(forResource: fileName, ofType: SECConstants.jsonFileExtension.rawValue) else {
            print("Could not find file named \(fileName)")
            return [:]
        }
        
        do {
            let data = try Data(contentsOf: URL(fileURLWithPath: path), options: .mappedIfSafe)
            let json = try JSONSerialization.jsonObject(with: data, options: .mutableLeaves) as? FileContents
            
            return json ?? [:]
        }
        catch {
            print("An error occured while reading json file: \(error)")
        }
        
        return [:]
    }
}
